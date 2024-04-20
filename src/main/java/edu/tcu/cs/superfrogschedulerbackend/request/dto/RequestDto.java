package edu.tcu.cs.superfrogschedulerbackend.request.dto;

import java.util.Date;

public record RequestDto(String customerFirstName,
                         String customerLastName,
                         String phoneNumber,
                         String email,
                         Date startTime,
                         Double duration,
                         String eventType,
                         String eventTitle,
                         String organizationName,
                         String eventAddress,
                         Boolean onCampus,
                         String specialInstructions,
                         String expensesAndBenefitsToSpiritTeam,
                         String otherOutsideOrganizations,
                         String eventDescription,
                         String status,
                         Boolean approved,
                         Boolean paid,
                         Double amount) {
}
