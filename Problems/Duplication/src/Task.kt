// Write your code here. Do not import any libraries
val filename = "MyFile.txt"
val myFile = File(filename)
val content = myFile.readText()
myFile.appendText(content)