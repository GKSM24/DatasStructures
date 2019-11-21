package module6.LearningByDoing1;

public class PriorityQueue {
    char[] queue;
    int size;
    PriorityQueue(){
        queue = new char[30];
        size = 0;
    }

    void insert(char ch){
        queue[size++] = ch;
        if(size > 1) {
            int index = size - 1, p_index = (index - 1)/2;
            while(p_index >= 0 && queue[index] > queue[p_index]){
                char temp = queue[index];
                queue[index] = queue[p_index];
                queue[p_index] = temp;
                index = p_index;
                p_index = (index - 1)/2;
            }
        }
    }

    char removeMax(){
        if(size > 0) {
            char return_temp = queue[0];
            queue[0] = queue[size - 1];
            int index = 0, l_child = 2*index + 1, r_child = l_child + 1;
            while(l_child < size && r_child < size && (queue[index] < queue[l_child] || queue[index] < queue[r_child])){
                if(queue[index] < queue[l_child]){
                    char temp = queue[index];
                    queue[index] = queue[l_child];
                    queue[l_child] = temp;
                    index = l_child;
                    l_child = 2*index + 1;
                }
                else if(queue[index] < queue[r_child]){
                    char temp = queue[index];
                    queue[index] = queue[r_child];
                    queue[r_child] = temp;
                    index = r_child;
                    r_child = 2*index + 2;
                }
            }
            size--;
            return return_temp;
        }
        return ' ';
    }

    void display(){
        for(int index = 0 ;index < size; index++)
            System.out.println(queue[index]);
    }

    public static void main(String[] args){
        String str = "PRIO*R**I*T*Y***QUE***U*E";
        PriorityQueue pq = new PriorityQueue();
        for(int index = 0; index < str.length(); index++){
            if(str.charAt(index) == '*')
                System.out.println(pq.removeMax());
            else
                pq.insert(str.charAt(index));
        }
        //pq.display();
    }
}
