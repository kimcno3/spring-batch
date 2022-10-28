package example.spring.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfiguration {

  public final JobBuilderFactory jobBuilderFactory;
  public final StepBuilderFactory stepBuilderFactory;

  /*
   * Tasklet 방식
   */


// 1. 단일 Job에 여러 Step 선언시

//  @Bean
//  public Job ExampleJob(){
//    Job exampleJob = jobBuilderFactory.get("exampleJob")
//        .start(StartStep())
//        .next(nextStep())
//        .next(lastStep())
//        .build();
//
//    return exampleJob;
//  }
//
//  @Bean
//  public Step StartStep() {
//    return stepBuilderFactory.get("startStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Start Step!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  @Bean
//  public Step nextStep(){
//    return stepBuilderFactory.get("nextStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Next Step!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  @Bean
//  public Step lastStep(){
//    return stepBuilderFactory.get("lastStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Last Step!!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }

// ------------------------------------------------------------------------------------------------

// 1-1. 문법 숙달을 위한 Job, Step

//  @Bean
//  public Job examJop() {
//    return jobBuilderFactory.get("examJop")
//        .start(examStep())
//        .build();
//  }
//
//  @Bean
//  public Step examStep() {
//    return stepBuilderFactory
//        .get("examStep")
//        .tasklet(((contribution, chunkContext) -> {
//          log.info("Exam Step 1");
//          return RepeatStatus.FINISHED;
//        }))
//        .build();
//  }

// ------------------------------------------------------------------------------------------------

// 2. Flow를 통한 Step 구성하기
//  @Bean
//  public Job ExampleJob(){
//
//    Job exampleJob = jobBuilderFactory.get("exampleJob")
//        .start(startStep())
//        .on("FAILED") //startStep의 ExitStatus가 FAILED일 경우
//        .to(failOverStep()) //failOver Step을 실행 시킨다.
//        .on("*") //failOver Step의 결과와 상관없이
//        .to(writeStep()) //write Step을 실행 시킨다.
//        .on("*") //write Step의 결과와 상관없이
//        .end() //Flow를 종료시킨다.
//
//        .from(startStep()) //startStep이 FAILED가 아니고
//        .on("COMPLETED") //COMPLETED일 경우
//        .to(processStep()) //process Step을 실행 시킨다
//        .on("*") //process Step의 결과와 상관없이
//        .to(writeStep()) // write Step을 실행 시킨다.
//        .on("*") //wrtie Step의 결과와 상관없이
//        .end() //Flow를 종료 시킨다.
//
//        .from(startStep()) //startStep의 결과가 FAILED, COMPLETED가 아닌
//        .on("*") //모든 경우
//        .to(writeStep()) //write Step을 실행시킨다.
//        .on("*") //write Step의 결과와 상관없이
//        .end() //Flow를 종료시킨다.
//        .end()
//        .build();
//
//    return exampleJob;
//  }
//
//  @Bean
//  public Step startStep() {
//    return stepBuilderFactory.get("startStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Start Step!");
//
//          String result = "COMPLETED";
////          String result = "FAIL";
////          String result = "UNKNOWN";
//
//          // Flow에서 on은 RepeatStatus가 아닌 ExitStatus를 바라본다.
//          if(result.equals("COMPLETED"))
//            contribution.setExitStatus(ExitStatus.COMPLETED);
//          else if(result.equals("FAIL"))
//            contribution.setExitStatus(ExitStatus.FAILED);
//          else if(result.equals("UNKNOWN"))
//            contribution.setExitStatus(ExitStatus.UNKNOWN);
//
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  @Bean
//  public Step failOverStep(){
//    return stepBuilderFactory.get("nextStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("FailOver Step!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  @Bean
//  public Step processStep(){
//    return stepBuilderFactory.get("processStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Process Step!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  @Bean
//  public Step writeStep(){
//    return stepBuilderFactory.get("writeStep")
//        .tasklet((contribution, chunkContext) -> {
//          log.info("Write Step!");
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }

}
