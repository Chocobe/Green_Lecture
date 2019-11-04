# 선택자

* "[]" 속성 선택자 : 특정 속성만 선택한다.

    ```css
        input[type="button"] { 
            
        }
    ```

* ">" 직계 자식 선택자 : 첫번째 자식 하나만 선택

    ```css
        .box > div {

        }

        #title > span {

        }

        body > .content {

        }
    ```

* "+" 형제 선택자 : 첫번째 형제 하나만 선택(자신 다음 형제)

    ```css
        .temp + p {

        }

        p + div {

        }
    ```

* "~" 모든 형제 선택자 : 모든 형제를 선택한다.

    ```css
        .temp ~ p {

        }
    ```

* ":nth-child(n) : n번째 형제 하나만 선택한다.

    ```css
        .temp:nth-child(3) {
            자신으로 부터 3번째 형제 하나 선택
        }

        .temp:nth-child(5) {
            자신으로 부터 5번째 형제 하나 선택
        }
    ```

* ":nth-child(2n) : 짝수 형제들을 모두 선택한다.

    ```css
        .temp:nth-child(2n) {
            짝수번째 형제들을 모두 선택한다.
        }
    ```

* ":nth-child(2n + 1) : 홀수 형제들을 모두 선택한다.

    ```css
        .temp:nth-child(2n + 1) {
            홀수번째 형제들을 모두 선택한다.
        }
    ```