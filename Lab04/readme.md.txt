a)
assertThat( found ).isEqualTo(alex);
assertThat(fromDb).isNull();
assertThat(fromDb).isNotNull();
assertThat(fromDb.getEmail()).isEqualTo( emp.getEmail());
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");

b)
mocks EmployeeService
public void whenPostEmployee_thenCreateEmployee( ) throws Exception {
        Employee alex = new Employee("alex", "alex@deti.com");

        //given(service.save(Mockito.any())).willReturn(alex);
        when( service.save(Mockito.any()) ).thenReturn( alex);

        mvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(alex)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("alex")));

        verify(service, times(1)).save(Mockito.any());

c)
@Mock - Pertence à biblioteca Mockito, é basicamente equivalente a ao metodo .mock() só deve ser utilizado dentro de uma classe de testes.
@MockBean - Pertence ao Spring Boot, pode ser utilizado em qualquer contexto da aplicação e subrepoe-se a beans já existentes do mesmo tipo.

d)
O ficheiro é utilizado para testar o projeto num container Docker com as configurações que estão especificadas no mesmo. Será utilizado se tentarmos testar com Docker.