Why you used ArrayList instead of array

Arrays are of fixed size but where as ArrayList is of dynamic size , by which we can add the student,courses and enrollments dynamically without distorting the fixed array size if we were using normal array.

Where you used static members and why

For IdGenerator we have used static variables to represent the generated courseId,studentId and enrollmentId , since the properties doesn't belong to any of the instance , whenever we add a new course or student or enroll a student it should be incremented from wherever we are accesing it and it can't be a particular instance's property .
Therefore , inorder to keep it as a class level attribute and to access the increment operator without instantiating the class we have kept static methods to increase the number of counts.

Where you used inheritance and what you gained from it

I have created an abstract class which is extended by Instructor and the student.
By inheriting we wouldn't need to provide class level attributes again for Instructor and Student as they are going to share these common attributes.
We kept it as an abstract class since Person shouldn't be instantiated on it's own as it either needs to be a student or an instructor.