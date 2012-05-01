import java.lang.String;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 * Classe para calcular interpolações pelo método de Lagrange
 * @author gustavo
 * @since 26/04/2012
 */
public class Lagrange {
    
    /**
     * Efetua o cálculo
     * 
     * @param Array ax
     * @param Array ay
     * @param double x
     * @return double
     * @throws Exception 
     */
    public static double calcula(double[]ax,double[]ay, double x) throws Exception{
        double[] prod = new double[ax.length];
        double[] lx = new double[ax.length];
        double rlinha = 1;
        for(int i = 1; i < ax.length;i++){
            lx[0] = x;
            rlinha = 1;
            for(int z = 1; z < ax.length;z++){
                lx[i] = x - ax[i];
                if(i == z){
                    continue;
                }else{
                    rlinha = rlinha *(ax[i] - ax[z]);
                }
            }
            prod[i] = rlinha;
        }
        double result = 0;
        for(int i = 1; i < ax.length;i++){
            double rx = 1;
            for(int z = 1; z < ax.length;z++){
                if(i == z){
                    continue;
                }else{
                    rx *= lx[z];
                }
            }
            result += ay[i] * rx / prod[i];
        }
        return result;
    }
    
    public static void main (String[]args) throws Exception{
        int n; 
        n = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho da matriz"));
        double[] ax = new double[n+1];
        double[] ay = new double[n+1];
        double x;
        for(int i = 1; i <= n; i++){
            ax[i] = Double.parseDouble(JOptionPane.showInputDialog("Ïnforme o valor "+i+" de x"));
        }
        for(int i = 1; i <= n; i++){
            ay[i] = Double.parseDouble(JOptionPane.showInputDialog("Ïnforme o valor "+i+" de y"));
        }
        x = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de x"));
        DecimalFormat DF = new DecimalFormat("0.0000");
        double result = calcula(ax, ay, x);
        JOptionPane.showMessageDialog(null, "O resultado da interpolação é: " + DF.format(result));
    }
    
}
