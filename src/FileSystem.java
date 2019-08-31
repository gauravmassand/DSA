import java.util.HashMap;
import java.util.Map;

class FileSystem {

    Map<String,Integer> map = new HashMap<>();

    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean create(String path, int value) {
        if(map.containsKey(path)) {
            return true;
        }
        int numberofSlash = countChar(path,'/');
        if(numberofSlash ==1) {
            map.put(path,value);
            return true;
        }
        else if(numberofSlash > 1) {
            int lastIndex =  path.lastIndexOf("/");
            String sub = path.substring(0,lastIndex);
            if(map.containsKey(sub)) {
                map.put(path,value);
                return true;

            }
            else {
                return false;
            }

        }
        return false;


    }

    public int get(String path) {
        if(map.containsKey(path)) {
            return map.get(path);
        }
        else {
            return -1;
        }

    }

    public int countChar(String str, char c) {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }

}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.create(path,value);
 * int param_2 = obj.get(path);
 */