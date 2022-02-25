package com.entertainment.entertainment_api.dtos.response.person.list;


import com.entertainment.entertainment_api.domain.Person;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ListPersonResponse {
    @ApiModelProperty(
            name = "Quantidade de Registros",
            notes = "quantidadeRegistros.",
            example = "quantidade: 2"
    )
    Integer getQuantidade();

//    @ApiModelProperty(
//            name = "List of Movies",
//            example = "{\n" +
//                    "\t\t\"id\": 1,\n" +
//                    "\t\t\"title\": \"Os Vingadores\",\n" +
//                    "\t\t\"sinopse\": \"LOKI, O IRMÃO DE THOR, GANHA ACESSO AO PODER ILIMITADO DO CUBO CÓSMICO AO ROUBÁ-LO DE DENTRO DAS INSTALAÇÕES DA S.H.I.E.L.D. NICK FURY, O DIRETOR DESTA AGÊNCIA INTERNACIONAL QUE MANTÉM A PAZ, LOGO REÚNE OS ÚNICOS SUPER-HERÓIS QUE SERÃO CAPAZES DE DEFENDER A TERRA DE AMEAÇAS SEM PRECEDENTES. HOMEM DE FERRO, CAPITÃO AMÉRICA, HULK, THOR, VIÚVA NEGRA E GAVIÃO ARQUEIRO FORMAM O TIME DOS SONHOS DE FURY, MAS ELES PRECISAM APRENDER A COLOCAR OS EGOS DE LADO E AGIR COMO UM GRUPO EM PROL DA HUMANIDADE.\",\n" +
//                    "\t\t\"duration\": \"12:00:00\"\n" +
//                    "\t\t\"releaseDate\": \"2012-04-27\"\n" +
//                    "\t}"
//    )
    List<Person> getPersons();
}
