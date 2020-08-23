// 1496. Path Crossing

// 爱奇艺 0823 秋招原题

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<List<Integer>> set = new HashSet();
        // List<Integer> list = new ArrayList(Arrays.asList(0, 0));
        set.add(Arrays.asList(0, 0));
        char[] track = path.toCharArray();
        
        int x=0, y=0;
        
        for(int i=0; i<track.length; i++) {
            switch(track[i]) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
            List<Integer> coords = new ArrayList(Arrays.asList(x, y));
            if(set.contains(coords)) {
                return true;
            } else {
                set.add(coords);
            }
        }
        return false;
    }
}
