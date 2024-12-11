package com.amrit.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono() throws InterruptedException {
//		System.out.println("Working with Mono");
////		Mono --> Publisher --> 0 or 1 element
//		Mono<String> m1 = Mono
//				.just("Code")
//						.log();
//
//		Mono<Object> error = Mono.error(new RuntimeException("Exception Occurred"))
//				.log();
////		Consumes the Mono by subscribing to it
//		m1.subscribe(System.out::println);
//		error.subscribe(System.out::println);
////		Flux --> Publisher --> 0 or N elements

		Mono<String> m1 = Mono.just("Code").log();
		Mono<String> m2 = Mono.just("With me").log();
		Mono<Integer> m3 = Mono.just(1).log();
//
//
//		Mono<Tuple3<String, String, Integer>> combineMono =
//				Mono.zip(m1, m2, m3);
//
//		combineMono.subscribe(System.out::println);
//
//		 m1.zipWith(combineMono)
//				.subscribe(System.out::println);

//		m1.map(String::toUpperCase)
//				.subscribe(System.out::println);
//
//		m1.flatMap(s -> Mono.just(s.toLowerCase())).log()
//				.subscribe(System.out::println);
//
//		m1.flatMapMany(s -> Flux.just(s.split(""))).log()
//				.subscribe(System.out::println);

		Flux<String> stringFlux = m1.concatWith(m2).log()
				.delayElements(Duration.ofMillis(2000));


		stringFlux.subscribe((data) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(data);
		});

		Thread.sleep(3000);
		System.out.println("End of the test");


	}

}
