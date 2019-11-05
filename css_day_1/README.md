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

---

# 요소 정렬하기

## ``display:flex``

*   ```css
        <style>
            .className {
                display: flex;
                flex-flow: row wrap;
                justify-content: space-around;
            }
        </style>

        <body>
            <div class="className">
                <div class="element_1"></div>
                <div class="element_2"></div>
            </div>
    ```

*   ``display:flex``

    *   이 요소의 하위(자식)요소를 설정에 따라 유연하게 배치한다.

    *   ``flex-flow``, ``space-around`` 속성으로 설정

*   ``flex-flow:속성``

    *   