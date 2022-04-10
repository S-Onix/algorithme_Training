package algorithm_fc.sort_ct;

public class BOJ10825 {
}

class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    @Override
    public int compareTo(Student other) {
        if(this.korean != other.korean) {
            return other.korean - this.korean;
        }

        if (this.english != other.english) {
            return this.english - other.english;
        }

        if(this.math != other.math) {
            return other.math - this.math;
        }

        return this.name.compareTo(other.name);
    }
}
