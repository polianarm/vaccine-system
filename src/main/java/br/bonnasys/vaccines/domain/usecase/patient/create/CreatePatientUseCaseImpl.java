package br.bonnasys.vaccines.domain.usecase.patient.create;

import br.bonnasys.vaccines.domain.model.Patient;
import br.bonnasys.vaccines.domain.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public final class CreatePatientUseCaseImpl implements CreatePatientUseCase{

    private final PatientRepository patientRepository;
    @Override
    public Patient execute(CreatePatientCommand command) {
        Patient patient = new Patient();

        String fullName = command.name();

        String[] fullNameArray = fullName.split(" ");

        String firstName = fullNameArray[0];
        String lastName = fullNameArray[fullNameArray.length-1];
        patient.setName(fullName);

        patient.setEmail(command.email());
        patient.setPhone(command.phone());

        patient.setBirthdate(command.birthdate());
        LocalDate birthdate = command.birthdate();
        Integer old = LocalDate.now().getYear() - birthdate.getYear();
        patient.setBirthdate(birthdate);


        String registration = """
                -----------------------------
                Solicitação:                    create
                Nome paciente:                  %s
                Sobrenome paciente:             %s
                Telefone de contato:            %s
                Idade do paciente:              %s
                -----------------------------
                """.formatted(firstName, lastName, command.phone(), old);
    log.info(registration);
        return patientRepository.save(patient);
    }
}
