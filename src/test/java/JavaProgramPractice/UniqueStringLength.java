package JavaProgramPractice;

import java.util.*;

class UniqueStringLength {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("bbtablud"));
//        System.out.println(lengthOfLongestSubstring("abcabcabc"));
        int[] arr1= {1,2,3,4,5}, arr2={6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List list= Arrays.asList(nums1);
        System.out.println(list.size());
        List list1 = Arrays.asList(nums2);
        System.out.println(list1);
        List list2 = new LinkedList();
        list2.add("Shashank");
        System.out.println(list2);
        list.addAll(list1);
        Collections.sort(list);
        int size = list.size();
        double mid=0;
        if(size%2==0){
            mid=((int)(list.get(size/2))+(int)(list.get((size/2)+1)))/2.0;
        } else{
            mid=((int)(list.get(size/2)));
        }

//        int m=nums1.length;
//        int n = nums2.length;
//        int maxLength = (m<n)?n:m;
//        int num3 [] = new int[m+n];
//        for (int i=0; i<(m+n);i++){
//            if(i<m){
//                num3[i]=nums1[i];
//            }
//            else {
//                num3[i]=nums2[i-m];
//            }
//        }
//        Arrays.sort(num3);
//        System.out.println(Arrays.toString(num3));
//        double mid=0;
//        if((m+n)%2==0){
//            System.out.println("first number is "+num3[maxLength/2]);
//            System.out.println("first number is "+num3[(maxLength/2)+1]);
//            mid=(num3[maxLength/2]+num3[(maxLength/2)+1])/2.0;
//        } else{
//            mid=(num3[maxLength/2]);
//        }
        return mid;
    }
}
