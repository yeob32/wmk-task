# wmk-task

### condition
1. 영어, 숫자 출력
2. 오름차순
3. 교차출력
4. 출력묶음단위

### API Documents

**문자 추출** `/submit` 
- 요청 `POST`
 - `url` : https://www.naver.com
 - `scope` : exclude
 - `outputUnit` : 7  
- 응답
 - `value` : 추출 문자열
 - `rest` : 나머지 문자열
```
{
  "value":"A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0A0",
  "rest":"zz"
}
```


