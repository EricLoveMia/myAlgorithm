package cn.eric.algorithm.leetcode.number;

/**
 * @ClassName LeetCodeNight
 * @Description: 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver

 * @Author eric
 * @Date 2019/11/19
 * @Version V1.0
 **/
public class LeetCodeNight {

    public void solveSudoku(int[][] board) {
        int length = board.length;
        int[][] temp = new int[length][length];
        boolean end = false;
        
        findResult(0,0,board);
        
    }

    private void findResult(int row, int column,int[][] board) {
        System.out.println("find：" + row + " / " + column);
        if(row >= board.length && column < board.length-1 ){
            return;
        }
        if(row >= board.length && column >= board.length){

            System.out.println("找到一个解");
            print(board);
            return;
        }
        for (int i = row; i < board.length; i++) {
            for (int j = column; j < board.length; j++) {
                if(board[i][j] == 0){
                    for (int k = 1; k <= 9; k++) {
                        if(checkExist(k,i,j,board)){
                            board[i][j] = k;
                            if(j < board.length -1 ){
                                findResult(i,j+1,board);
                            }else{
                                findResult(i+1,0,board);
                            }
                            board[i][j] = 0;
                        }
                    }
                }
            }
        }
    }
    

    boolean checkExist(int number, int row, int column, int[][] board){
        System.out.println("find：" + row + " / " + column + " / " + number);
        // 首先看行 列 里面是否有重复的
        for (int i = 0; i < board.length; i++) {
            if(board[i][column] == number || board[row][i] == number){
                return false;
            }
        }
        // 对角线有没有重复
        // 再看对角线有没有  左上
        for (int k = row - 1,m = column - 1; k>=0 && m>=0; k--,m--) {
            if(board[k][m] == number){
                return false;
            }
        }
        // 右上
        for (int k = row - 1,m = column + 1; m<board.length && k>=0; k--,m++) {
            if(board[k][m] == number){
                return false;
            }
        }

        // 再看对角线有没有  左下
        for (int k = row + 1,m = column - 1; k<board.length && m>=0; k++,m--) {
            if(board[k][m] == number){
                return false;
            }
        }
        // 再看对角线有没有  右下
        for (int k = row + 1,m = column + 1; k<board.length && m<board.length; k++,m++) {
            if(board[k][m] == number){
                return false;
            }
        }
        
        // 小9宫格有没有重复
        int pieceRow = row / 3;
        int pieceColumn = column / 3;
        for (int i = pieceRow*3 ; i < pieceRow*3 + 3; i++) {
            for (int j = pieceColumn*3 ; j < pieceColumn*3 + 3 ; j++) {
                if(board[i][j] == number){
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(int[][] board){//打印结果
        for(int i=0;i<9;i++){
            for(int m=0;m<9;m++){
                System.out.print(board[i][m] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        LeetCodeNight leetCodeNight = new LeetCodeNight();
        leetCodeNight.solveSudoku(board);
    }
}
