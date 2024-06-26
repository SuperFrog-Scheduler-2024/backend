package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StudentPaymentController {

    private final StudentPaymentService studentPaymentService;
    private final RequestRepository requestRepository;


    //injecting service via constructor
    public StudentPaymentController(StudentPaymentService studentPaymentService, RequestRepository requestRepository) {
        this.studentPaymentService = studentPaymentService;
        this.requestRepository = requestRepository;
    }

    @PostMapping("api/v1/studentpaymentform")
    public Result generateStudentPaymentForms(@RequestBody Request request) {
        //get the list of Requests
        List<Request> completedRequestsList = this.requestRepository.findByStatus("Completed");

        //get the payment period for a student
        Double studentPaymentPeriod = request.getDuration(); //this is the time elapsed for the event

        //generate a payment forms
        List<StudentPayment> paymentForms = this.studentPaymentService.generateStudentPaymentForm(completedRequestsList, studentPaymentPeriod); //continue working on this method. maybe it should accept the final map with completed requets.

        return new Result(true, StatusCode.SUCCESS, "Student payment forms generated successfully.");

    }
}
