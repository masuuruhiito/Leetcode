package com.shijianwei.main.learn.DesignPattern.FactoryPattern;

/**
 * @author SHI
 * @date 2022/2/28 16:12
 */
public class FactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory= new CourseFactory();
        System.out.println(courseFactory.create(JavaCourse.class));
        System.out.println(courseFactory.create(JavaCourse.class));
        System.out.println(courseFactory.create(JavaCourse.class));


        System.out.println(courseFactory.create(PythonCourse.class));
        System.out.println(courseFactory.create(PythonCourse.class));
        System.out.println(courseFactory.create(PythonCourse.class));
        System.out.println(courseFactory.create(PythonCourse.class));
    }
}
