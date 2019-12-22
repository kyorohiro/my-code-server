import numpy as np
import scipy.linalg as linalg
import pandas as pd

from scipy.optimize import minimize_scalar
from matplotlib import pyplot as plt
import seaborn as sns
import requests
import io
import zipfile
import pandas as pd

sns.set()

#url = "http://archive.ics.uci.edu/ml/machine-learning-databases/00356/student.zip"
#print("START")
#r = requests.get(url, stream=True)
#z = zipfile.ZipFile(io.BytesIO(r.content))
#z.extractall()
print("EXZTRACT")
data = pd.read_csv("student-mat.csv", sep=";")
h = data.head()
print(h)
print(data.info())
print(data["sex"].head())

#plt.hist(data["absences"])
#sns.pairplot(data[["Dalc","Walc","G1","G3"]])
plt.plot(data["G1"],data["G3"],"o")
plt.savefig("test.png")
print("mean: {}".format(data["absences"].mean()))
print("medium: {}".format(data["absences"].median()))
print("mode: {}".format(data["absences"].mode()) )
print("std: {}".format(data["absences"].std()) )
print("xx: {}".format(data.describe()))



print("END")

