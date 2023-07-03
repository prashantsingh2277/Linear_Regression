# Linear_Regression
Linear regression establishes a relationship between a dependent variable and independent variables. It finds a best-fit line that minimizes differences between observed and predicted values. It predicts outcomes and assesses the impact of independent variables on the dependent variable.
The given Java code implements linear regression. It includes a Linear_regression class with methods for fitting the model and predicting outcomes.

In the main method, a sample dataset X and target variable y are provided. The model is instantiated, and the fit method is called to train the model using the dataset.

Then, user input is collected for study hours, attendance, and sports performance. The predict method is used to predict the performance based on the user input. The predicted value is printed as the output.

The fit method calculates the coefficients and intercept for the linear regression model using the provided dataset. It calculates the means, covariance, and deviations of the independent variables (x) and the target variable (y). The coefficients are computed using the covariance and deviation values.

The dotproduct method calculates the dot product of the coefficients and independent variable means.

Overall, this code demonstrates how to implement linear regression in Java and use it for prediction based on user input.
X in main function indicates dataset of performance of student namely study hours,attendance in class and sports performance.
y contains the predicted value for all data in X.
