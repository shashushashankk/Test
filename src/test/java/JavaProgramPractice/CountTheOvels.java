package JavaProgramPractice;

public class CountTheOvels {
    public static void main(String[] args) {
        System.out.println(countOvels("Shashank"));
    }
    static int countOvels(String str){
        int count=0;
        for(int i = 0; i<str.length(); i++){
            char val = str.toLowerCase().charAt(i);
            if(val=='a' || val =='e'||val=='i'||val=='o'||val=='u'){
                count++;
            }
        }
        return count;
    }
}
