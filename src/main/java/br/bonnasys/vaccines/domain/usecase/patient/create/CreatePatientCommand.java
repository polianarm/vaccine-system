package br.bonnasys.vaccines.domain.usecase.patient.create;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

//@AllArgsConstructor
public record CreatePatientCommand(String name,
                                   String phone,
                                   String email,
                                   LocalDate birthdate) {

    //comando usado para criar um novo paciente nem sempre
    // sempre serão usados só esses, as vezes haverão outros detalhes,
    // exemplo, tudo que precisamos para criar ou executar aquela funcao especifica, pode add mais atributos, nem sempre vao estar na entidade do banco de dados,

    //vamos montar o objeto do comand e propagar para o nosso serviço, a gente nao vai atualizar, é só um comando para pegar infos do nosso controlador para o nosso serviço
        //desse modo a gente nao vai chamar setter, só o getter; esses dados sao imutaveis
    //podemos transformar essa classe tipo record, para gerenciar dados imultaveis
}
