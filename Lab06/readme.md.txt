Aluno: Luís Valentim 93989
Aula: TQS Lab06

Ex1
  
  c) Utilizei mvn clean verify sonar:sonar -Dsonar.login=myAuthenticationToken para adicionar a análise do projeto ao dashboard do sonarqube
     Foram identificados 1 Bug, 1 security hotspot e 25 code smells.

  e)
     A análise passou o quality gate Sonar way default com as seguintes condições
     Conditions on New Code
	Metric	Operator	Value
	Coverage	is less than	80.0%
	Duplicated Lines (%)	is greater than	3.0%
	Maintainability Rating	is worse than	A
	Reliability Rating	is worse than	A
	Security Hotspots Reviewed	is less than	100%
	Security Rating	is worse than	A

  f)
	Bug			Randoms não deve voltar a ser chamado					Guardar o random calculado da primeira vez e reutiliza-lo
	Vulnerability 		-									-
	Security Hotspot	Usar geradores pseudo aleatórios está associado a algumas CVE's		Utilizar multiplos geradores para não existir qualquer padrão, ou utilizar um gerador mais seguro.
	Code Smell		Logger invés de System.out.*						A informação deve ser passada a um logger e não printada diretamente
	Code Smell		Não utilizar o loop counter dentro do loop				Não atualizar a variável de looping dentro do loop
	Code Smell		Remover o modifier public de várias instâncias				Passar os publics a privates
	...

Ex2

  a) O projeto tem 2h de technical debt, ou seja seria necessário um programador trabalhar 2 horas para resolver todos os problemas encontrados.

  d) 134, o numero de linhas de código que não estão a ser testadas por unit tests.							