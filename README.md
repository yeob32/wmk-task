# wmk-task
## 개요
임의의 URL을 입력 받아 해당 HTML 문서의 특정 문자열을 추출한다.

## 요구사항
1. 영어, 숫자 출력
2. 오름차순
3. 교차출력
4. 출력묶음단위

## API Documents
**문자 추출** `/submit` 
- 요청 `POST`
 - `url` : https://www.naver.com
 - `scope` : exclude
 - `outputUnit` : 7  
- 응답
 - `value` : 추출 문자열
 - `rest` : 나머지 문자열   
**sample**
```
{
  "value":"A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0",
  "rest":"zz"
}
```


