import java.util.Scanner;

public class Linear_regression {

    double []coffecients;
    double intercept;

    public static void main (String []args){
        double [][]X={{1.0,0.75,0.7},{3.0,0.8,0.6},{4.0,0.85,0.5},{5.0,0.75,0.6},{8.0,0.9,0.5},{1.0,0.75,0.5},{3.0,0.8,0.4},{5.0,0.85,0.5},
                            {6.0,0.5,0.7},{10,0.9,0.3},{1,0.4,0.8},{1.0,0.9,0.5},{10,0.9,0.2},{1.0,0.3,0.9},{0.0,0.9,0.9},{0.0,0.0,0.8},};
        double []y={8.0,8.5,9.2,9.3,9.7,8.2,8.7,9.4,8.5,9.9,6.0,8.4,10.0,5.4,7.5,3.5};

        Linear_regression model=new Linear_regression();
        model.fit(X,y);

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the study hours         :>  ");
        double x1=scanner.nextDouble();
        
         System.out.print("Enter the attendence         :>  ");
        double x2=scanner.nextDouble();
         
         System.out.print("Enter the sports performance :>  ");
        double x3=scanner.nextDouble();
          System.out.println();
         double[]xtest={x1,x2,x3};
         double prediction=model.predict(xtest);
         if(prediction>10.0){
            prediction=10.0;
         }
         System.out.println("Predicted performance ::>  "+prediction);

    }

    private double predict(double[] xtest) {
        return dotproduct(coffecients, xtest)+intercept;
    }

    private void fit(double[][] x, double[] y) {
        
        int ns=x.length;
        int nf=x[0].length;

        double[] xmeans=new double[nf];
        double ymeans=0.0;

        for(int i=0;i<ns;i++){
            for(int j=0;j<nf;j++){
                xmeans[j]=xmeans[j]+x[i][j];
            }

            ymeans=ymeans+y[i];
        }

        for(int i=0;i<nf;i++){
            xmeans[i]=xmeans[i]/ns;
        }

        ymeans=ymeans/ns;

        double []xcovar=new double [nf];
        double ycovar=0.0;

        for(int i=0;i<ns;i++){
            for(int j=0;j<nf;j++){

                xcovar[j]=xcovar[j]+(x[i][j]+xmeans[j])*(y[i]-ymeans);
            
            }
            ycovar=ycovar+(y[i]+ymeans)*(y[i]-ymeans);
        }



        double []xdev=new double [nf];
        double ydev=0.0;

        for(int i=0;i<ns;i++){
            for(int j=0;j<nf;j++){

                xdev[j]=xcovar[j]+Math.pow((x[i][j]-xmeans[j]),2);
            
            }
            ydev=ydev+Math.pow((y[i]-ymeans),2);
        }
        coffecients=new double[nf];

        for(int i=0;i<nf;i++){
            coffecients[i]=xcovar[i]/xdev[i];
        }

        intercept=ymeans -dotproduct(coffecients,xmeans);
        
    }

    private double dotproduct(double[] coffecients2, double[] xmeans) {
        double result=0.0;

        for(int i=0;i<coffecients2.length;i++){
            result=result+(coffecients2[i]*xmeans[i]);
        }

        return result;
        
    }
    
}
