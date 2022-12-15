public class MinimalPassiveSearch {


    private double f(double x) {
        return Math.pow(x, 2);
    }

    public void odd(double x_start, double x_stop, int grid_nodes_count) {
        if (grid_nodes_count < 2) {
            System.out.println(x_start + ", " + x_stop);
        }
        else {

            double length = Math.abs(x_stop - x_start);
            double step = length / (grid_nodes_count + 1);

            double[] x_i = new double[grid_nodes_count + 2];
            double[] f_i = new double[grid_nodes_count + 2];

            for (int i = 0; i < grid_nodes_count + 2; i++) {
                x_i[i] = x_start + step * i;
                f_i[i] = f(x_i[i]);
            }

            int minIndex = getMinIndex(f_i, false);

            double x_min = x_i[minIndex];
            double f_min = f_i[minIndex];

            printResult(x_i, f_i, x_min, f_min);

        }

    }

    public void even(double x_start, double x_stop, int grid_nodes_count, double delta) {

        double length = Math.abs(x_stop - x_start);
        double step = length / (grid_nodes_count / 2.0 + 1);

        assert (delta <= step) : "Дельта должна быть не больше шага.";

        double[] x_i = new double[grid_nodes_count + 2];
        double[] f_i = new double[grid_nodes_count + 2];

        x_i[0] = x_start;
        x_i[x_i.length - 1] = x_stop;

        for (int i = 1; i < Math.floorDiv(grid_nodes_count, 2) + 1; i++) {
            x_i[i*2 - 1] = x_start + step * i;
            x_i[i*2] = x_start + step * i + delta;
        }
        for (int i = 0; i < f_i.length; i++) f_i[i] = f(x_i[i]);

        int minIndex = getMinIndex(f_i, true);

        double x_min = x_i[minIndex];
        double f_min = f_i[minIndex];

        printResult(x_i, f_i, x_min, f_min);
    }

    public void odd_with_break(double x_start, double x_stop, int grid_nodes_count) {
        if (grid_nodes_count < 2) {
            System.out.println(x_start + ", " + x_stop);
        }
        else {
            double length = Math.abs(x_stop - x_start);
            double step = length / (grid_nodes_count + 1);

            double[] x_i = new double[grid_nodes_count + 2];
            double[] f_i = new double[grid_nodes_count + 2];

            for (int i = 0; i < grid_nodes_count + 2; i++) {
                x_i[i] = x_start + step * i;
                f_i[i] = f(x_i[i]);
            }

            int minIndex = getMinIndex(f_i, true);

            double x_min = x_i[minIndex];
            double f_min = f_i[minIndex];

            printResult(x_i, f_i, x_min, f_min);

        }

    }

    public void v4(double x_start, double x_stop, double eps){
        double length = Math.abs(x_stop - x_start);
        int grid_nodes_count = (int) (length / eps) - 1;
        double step = length / (grid_nodes_count + 1);

        double[] x_i = new double[grid_nodes_count + 2];
        double[] f_i = new double[grid_nodes_count + 2];

        for (int i = 0; i < x_i.length; i++) x_i[i] = x_start + step*i;
        for (int i = 0; i < f_i.length; i++) f_i[i] = f(x_i[i]);

        int minIndex = getMinIndex(f_i, true);

        double x_min = x_i[minIndex];
        double f_min = f_i[minIndex];

        printResult(x_i, f_i, x_min, f_min);

    }

    private void printResult(double[] x_i, double[] f_i, double x_min, double f_min) {
        System.out.printf("\nMin x = %.4f. Min f(x) = %.4f.\n", x_min, f_min);
        System.out.print("[");
        for (double v : x_i) System.out.printf("%.3f ", v);
        System.out.print("]\n[");
        for (double v : f_i) System.out.printf("%.3f ", v);
        System.out.print("]\n");
    }

    private int getMinIndex(double[] f_i, boolean withBreak) {
        int j = 0;
        double f_min = f_i[0];

        if (withBreak) {
            for (int i = 0; i < f_i.length; i++) {
                if (f_i[i] < f_min) {
                    f_min = f_i[i];
                    j = i;
                }
                else if (f_i[i] > f_min) return j;
            }
        }
        else {
            for (int i = 0; i < f_i.length; i++) {
                if (f_i[i] < f_min) {
                    f_min = f_i[i];
                    j = i;
                }
            }
        }
        return j;
    }


}
