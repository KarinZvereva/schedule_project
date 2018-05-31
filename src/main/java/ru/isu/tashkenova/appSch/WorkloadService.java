package ru.isu.tashkenova.appSch;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface WorkloadService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("role")
    Call<List<Role>> getRole();

    @GET("studentsClass")
    Call<List<StudentsClass>> getStudentClasses();

    @GET("subject")
    Call<List<Subject>> getSubjects();

    @GET("workload")
    Call<List<Workload>> getWorkload();
}
