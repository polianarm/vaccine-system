package br.bonnasys.vaccines.domain.usecase.patient.create;

import br.bonnasys.vaccines.domain.model.Patient;

public sealed interface CreatePatientUseCase permits CreatePatientUseCaseImpl {

    //destinada unica e exclusivamente para criar um paciente

    Patient execute(CreatePatientCommand command);

}
