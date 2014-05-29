package oj;

public class SetZeros {
    void setZeroHorizontal(int[][] matrix, int row, int cs, int ce) {
        for (int i = cs; i < ce; ++i)
            matrix[row][i] = 0;
    }

    void setZeroVertical(int[][] matrix, int col, int rs, int re) {
        for (int i = rs; i < re; ++i)
            matrix[i][col] = 0;
    }

    void setZerosHelper(int[][] matrix, int rs, int re, int cs, int ce) {
        for (int i = rs; i < re; ++i) {
            for (int j = cs; j < ce; ++j) {
                if (matrix[i][j] == 0) {
                    setZerosHelper(matrix, rs + 1, re, cs, j - 1);
                    setZerosHelper(matrix, rs + 1, re, j + 1, ce);

                    for (int p = cs; p < ce; ++p) {
                        if (p == j)
                            continue;

                        if (matrix[i][p] == 0 || (i + 1 < re && matrix[i+1][p] == 0)) {
                            setZeroVertical(matrix, p, rs, re);
                        }
                    }

                    for (int p = i + 1; p < re; ++p) {
                        if (matrix[p][j] == 0 || (j - 1 >= cs && matrix[p][j-1] == 0) ||
                                ((j + 1 < ce && matrix[p][j+1] == 0))) {
                            setZeroHorizontal(matrix, p, cs, ce);
                        }
                    }

                    setZeroHorizontal(matrix, i, cs, ce);
                    setZeroVertical(matrix, j, rs, re);

                    return;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        setZerosHelper(matrix, 0, matrix.length, 0, matrix[0].length);
    }

    void PrintM(int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] m = { {0,0,0,5 }, {4,3,1,4}, {0,1,1,4}, {1,2,1,3}, {0,0,1,1}};

        SetZeros s = new SetZeros();
        s.PrintM(m);
        s.setZeroes(m);
        s.PrintM(m);
    }
}
