package module9.LearningByDoing3;


class Hashtable {
    Character[] hashtable;

    Hashtable(int capacity) {
        hashtable = new Character[capacity];
    }

    public int hashFunc(char k) {
        return k % hashtable.length;
    }

    void put(char key) {
        int index = hashFunc(key);
        //System.out.println(index);
        if(hashtable[index] == null)
            hashtable[index] = key;
        else{
            while(hashtable[index] != null)
                index = (index+1) % hashtable.length;
            hashtable[index] = key;
        }
    }
}

public class Assignment {
    public static void main(String[] args) {
        String str = "ABCDEFG";
        Hashtable h_obj = new Hashtable(7);
        for(int index = 0; index<str.length();index++)
            h_obj.put(str.charAt(index));
        for(int index = 0; index<h_obj.hashtable.length;index++)
            System.out.println(h_obj.hashtable[index]);
    }
}