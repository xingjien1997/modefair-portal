import { Student } from "./student.model";

export class StudentSchedule{
    student!: Student;
    schedule!: Schedule;

    constructor(student: Student, schedule: Schedule) {
        
    }
}

export interface Schedule {
    id: number,
    course: Course,
    lecturer: Lecturer,
    semester: number,
    year: number
}

export interface Lecturer {
    id: number,
    lecturerName: string;
    department: Department,
    course: Course,
}

export interface Department {
    id: number,
    departmentName: string
}

export interface Course {
    id: number,
    courseName: string,
    courseCredits: number
}