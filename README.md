# testProject03
spring 공부 :: 의존객체 자동주입


### xml파일에서
1. <constructor-arg ref = "dao" /> 형식으로 reference 를 가져와 사용하는것을
2. 의존객체 자동주입으로 dao를 알아서 넣어주게끔 한다 => <constructor-arg ref = ""/> 삭제
3. 의존객체를 가져와 쓰는 service단으로 가서 Autowired 또는 Resource 사용

### Autowired
1. 생성자, property, method에 넣어 사용 가능
2. 단, property나 method에 사용하려면 반드시 default 생성자를 명시해야함

### Resource
1. 생성자에는 못쓰고, property 또는 method만 사용가능
2. Resource 쓸 때 import javax.annotation.Resource 추가 해도 빨간줄 생기면 pom.xml dependency 추가
	<dependency>
		<groupId>javax.annotation</groupId>
		<artifactId>javax.annotation-api</artifactId>
		<version>1.3.1</version>
	</dependency>
