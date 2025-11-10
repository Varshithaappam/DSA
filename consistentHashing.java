import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class consistentHashing {
    private final SortedMap<Long, String> hashRing=new TreeMap<>();
    private final MessageDigest md;
    private final int numberOfReplicas;
    
    public consistentHashing(int numberOfReplicas) throws NoSuchAlgorithmException {
        this.numberOfReplicas=numberOfReplicas;
        this.md=MessageDigest.getInstance("MD5");
    }

    public void addServer(String serverName) {
        for(int i=0;i<numberOfReplicas;i++){
            long hash=generateHash(serverName+"-"+i);
            hashRing.put(hash,serverName);
        }
    }

    public void removeServer(String serverName) {
        for(int i=0;i<numberOfReplicas;i++){
            long hash=generateHash(serverName+"-"+i);
            hashRing.remove(hash);
        }
    }

    private long generateHash(String input) {
        md.reset();
        md.update(input.getBytes());
        byte[] digest=md.digest();
        long hash=0;
        for(int i=0;i<8;i++){
            hash=(hash<<8)| (digest[i] & 0xFF);
        }
        return hash;
    }

    public String getServer(String key) {
        if(hashRing.isEmpty()){
            return null;
        }
        long keyHash=generateHash(key);
        SortedMap<Long,String> tailMap=hashRing.tailMap(keyHash);
        if(tailMap.isEmpty()){
            return hashRing.get(hashRing.firstKey());
        }
        else{
            return tailMap.get(tailMap.firstKey());
        }
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        consistentHashing ch = new consistentHashing(3);
       
        ch.addServer("ServerA");
        ch.addServer("ServerB");
        ch.addServer("ServerC");

        System.out.println("key 'data1' maps to: " + ch.getServer("data1"));
        System.out.println("key 'data2' maps to: " + ch.getServer("data2"));
        System.out.println("key 'data3' maps to: " + ch.getServer("data3"));

        System.out.println("\nRemoving ServerB...");
        ch.removeServer("ServerB");

        System.out.println("Key 'data1' now maps to : "+ch.getServer("data1"));
        System.out.println("Key 'data2' now maps to : "+ch.getServer("data2"));
        System.out.println("Key 'data3' now maps to : "+ch.getServer("data3"));
    }
}