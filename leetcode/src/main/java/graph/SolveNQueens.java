package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubo
 * @ClassName SolveNQueens
 * @Description TODO
 * @Date 2020/5/6
 * @since JDK 1.8
 */
public class SolveNQueens {
    // 最终的返回结果
   static List<List<String>> res=new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        //初始化皇后数组  每一个都用 . 来表示
        char [][] a=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]='*';
            }
        }

        //开始进行填充皇后 传入皇后数组和 开始的行
        backtrack(a,0);
        return  res;
    }
    public static void backtrack(char [][] board,int row){

        int n=board.length;
        //当行号和数组的长度相等说明已经到了把所有Q都插进了数组 那么开始处理返回结果
        //例如 n=4  当你的row=4说明前面的都已经填充完了 这时候就是我们要的结果
        if(row==n){
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
            return;
        }
        //回溯的第一步 遍历选择列表  决定我们该选择哪一个 这里我们有n种选择  代表我们选择的列号
        for(int cloum=0;cloum<n;cloum++){
            if(!isvaild(board,row,cloum)) continue; //判断在当前行当前列插入一个Q是否合法
            board[row][cloum]='Q'; //如果和合法 则将当前位置插入Q
            backtrack(board,row+1);  //进行下一步  去下一行插入Q   如果下一行的位置始终不合法 则回溯
            board[row][cloum]='*'; //回溯 把当前位置 重新置成.
        }
    }
    //判断 在当前行当前列的插入是否合法
    public static boolean isvaild(char[][]board,int row,int cloum){
        int n=board.length;
//判断当前一整列是否有Q  如果有则返回false 代表当前列不能插入
        for(int i=0;i<n;i++){
            if(board[i][cloum]=='Q')return  false;
        }
        //右上方是否有Q
        for(int i=row-1,j=cloum+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        //右下方
        for (int i=row+1,j=cloum+1;i<n&&j<n;i++,j++){
            if(board[i][j]=='Q') return  false;
        }
        //左上方
        for (int i=row-1,j=cloum-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q') return  false;
        }
        //左下方
        for (int i=row+1,j=cloum-1;i<n&&j>=0;i++,j--){
            if(board[i][j]=='Q') return  false;
        }

        return  true;
    }


    public static void main(String[] args) {
        List<List<String>> ts= solveNQueens(8);
        System.out.println(ts.size());
        for (List<String> a:ts){
            for (String b:a){
                System.out.println(b);
            }
            System.out.println("\\r\\n");
        }
    }
}
