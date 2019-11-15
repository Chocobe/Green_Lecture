# 위치 지정

* ``margin``을 적용하기 위해서 필요한 선행 설정

    * 해당 요소가 ``block`` 이면서
    
    * ``position:static``(기본값) 일 것
    
* ``top``, ``left``, ``bottom``, ``right``를 적용하기 위해서 필요한 선행 설정

    * 해당 요소가 ``inline`` 또는 ``block-line`` 일 것
    
    * ``position:relative`` 또는 ``position:absolute``일 것
    
# 반응형 웹의 Layout 작성시 유의사항

* 가로길이(width)값 : **%값**

* 세로길이(height)값 : **px값(고정값)**

* 각 요소의 크기 계산을 위한 **border** 설정

    * ``box-sizing:border-box;``