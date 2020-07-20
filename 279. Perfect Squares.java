// 279. Perfect Squares

class Solution {
    int res = Integer.MAX_VALUE;
    public int numSquares(int n) {
        List<Integer> square = new ArrayList();
        for(int i=1; i*i<=n; i++) {
            square.add(i*i);
        }
        numSquares(n, square, square.size()-1, 0);
        return res;
    }
    public void numSquares(int n, List<Integer> square, int index, int num) {
        if(num >= res) return;
        if(n == 0) {
            res = num;
            return;
        }
        if(index == -1) return;
        int cur = square.get(index);
        if(n >= cur) {
            numSquares(n%cur, square, index-1, num+(n/cur));
        }
        numSquares(n, square, index-1, num);
        return;
    }
}


// The following method is not faster here, but it is inspiring for other question
class Square {
    int n, len;
    Square(int n, int len) {
        this.n = n;
        this.len = len;
    }
}

class Comparator_Square implements Comparator<Square> {
    public int compare(Square x, Square y) {
        return x.len != y.len ? x.len-y.len : x.n - y.n;
    }
}

class Solution {
    public int numSquares(int n) {
        List<Integer> squareNum = new ArrayList();
        for(int i=1; i*i<=n; i++) squareNum.add(i*i);
        PriorityQueue<Square> queue = new PriorityQueue(new Comparator_Square());
        queue.add(new Square(n, 0));
        while(!queue.isEmpty()) {
            Square cur = queue.poll();
            if(cur.n == 0) return cur.len;
            for(int i=squareNum.size()-1; i>=0; i--) {
                int snum = squareNum.get(i); 
                if(cur.n >= snum) {
                    Square temp = new Square(cur.n%snum, cur.len+(cur.n/snum));
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }
}
