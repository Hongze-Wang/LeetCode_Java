// 350. Intersection of Two Arrays II

// two pointers need sorting
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while(i<nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        // return res.toArray(); //error: incompatible types: Object[] cannot be converted to int[]
        return res.stream().mapToInt(k->k).toArray();
        // return Arrays.asList(res); // error: incompatible types: no instance(s) of type variable(s) T exist so that List<T> conforms to int[]
    }
}

// hashmap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList(); 
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    res.add(nums2[i]);
                }
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        return res.stream().mapToInt(k->k).toArray();
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList(); 
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    res.add(nums2[i]);
                }
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] out = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList(); 
        HashMap<Integer, Integer> map = new HashMap();
        int k=0;
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    res.add(nums2[i]);
                    k++;
                }
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] out = new int[k];
        for(int i=0; i<k; i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}
