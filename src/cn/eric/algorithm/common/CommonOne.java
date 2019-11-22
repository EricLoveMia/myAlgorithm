package cn.eric.algorithm.common;

/**
 * @ClassName CommonOne
 * @Description:
 *
 * 八皇后问题
 *
 * @Author YCKJ2725
 * @Date 2019/11/19
 * @Version V1.0
 **/
public class CommonOne {
    /** 棋盘，放皇后 */
    public static int[][] array=new int[8][8];
    /** 存储方案结果数量 */
    public static int map=0;

    public static void main(String[] args) {
        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有："+map+"种可能");
    }

    private static void findQueen(int row) {
        if(row > array.length-1){
            map++;
            print();
            return;
        }

        for (int column = 0; column < array.length ; column++) {
            // check 用来判断能不能放的下
            if(check(row,column)){
                array[row][column] = 1;
                findQueen(row+1);
                // 只要回溯回来了，都清零
                array[row][column] = 0;
            }

        }
    }

    private static boolean check(int row, int column) {

        // 要在 row column这里放一个皇后
        // 先看 行列上有没有
        for (int i = 0; i < array.length; i++) {
            if(array[row][i] == 1){
                return false;
            }
            if(array[i][column] == 1){
                return false;
            }
        }


        // 再看对角线有没有  左上
        for (int k = row - 1,m = column - 1; k>=0 && m>=0; k--,m--) {
            if(array[k][m] == 1){
                return false;
            }
        }
        // 右上
        for (int k = row - 1,m = column + 1; m<array.length && k>=0; k--,m++) {
            if(array[k][m] == 1){
                return false;
            }
        }

        // 再看对角线有没有  左下
        for (int k = row + 1,m = column - 1; k<array.length && m>=0; k++,m--) {
            if(array[k][m] == 1){
                return false;
            }
        }
        // 再看对角线有没有  右下
        for (int k = row + 1,m = column + 1; k<array.length && m<array.length; k++,m++) {
            if(array[k][m] == 1){
                return false;
            }
        }
        return true;
    }

    public static void print(){//打印结果
        System.out.print("方案"+map+":"+"\n");
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(array[i][m]==1){
                    System.out.print("o ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
