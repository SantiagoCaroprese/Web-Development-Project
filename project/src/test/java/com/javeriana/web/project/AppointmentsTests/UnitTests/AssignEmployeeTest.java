package com.javeriana.web.project.AppointmentsTests.UnitTests;

import com.javeriana.web.project.Appointments.Appointment.Application.Assign.AppointmentAssigner;
import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class AssignEmployeeTest {
   /* @Test
    void should_assign_employee(){
       /* Appointment appointment = new Appointment(new AppointmentId("17b69c93-9fc1-476d-a143-051435f903dd"),
                mock(AppointmentProperty.class),
                new AppointmentDateTime(LocalDateTime.now()),
                Optional.empty(),
                new AppointmentCustomerFirstName("Paul"),
                new AppointmentCustomerLastName("Cross"),
                new AppointmentCustomerEmail("paulcross@email.com"),
                new AppointmentCustomerPhoneNumber("3269804356")
        );

        AssignedEmployee assignedEmployee = new AssignedEmployee("d9942df6-c311-4bc5-8a02-e2797ea2dc82",
                "jon@email.com","jon","sand");

        Appointment updatedAppointment = new Appointment(new AppointmentId("17b69c93-9fc1-476d-a143-051435f903dd"),
                mock(AppointmentProperty.class),
                new AppointmentDateTime(LocalDateTime.now()),
                Optional.ofNullable(assignedEmployee),
                new AppointmentCustomerFirstName("Paul"),
                new AppointmentCustomerLastName("Cross"),
                new AppointmentCustomerEmail("paulcross@email.com"),
                new AppointmentCustomerPhoneNumber("3269804356")
        );

        AppointmentRepository repository = mock(AppointmentRepository.class);

        Mockito.when(repository.find("17b69c93-9fc1-476d-a143-051435f903dd")).thenReturn(Optional.of(appointment));

        AppointmentAssigner useCase = new AppointmentAssigner(repository);

        useCase.execute("17b69c93-9fc1-476d-a143-051435f903dd",
                "d9942df6-c311-4bc5-8a02-e2797ea2dc82","jon@email.com","jon","sand");

        verify(repository, atLeastOnce()).assignEmployee("17b69c93-9fc1-476d-a143-051435f903dd", updatedAppointment);


    }
*/

}
