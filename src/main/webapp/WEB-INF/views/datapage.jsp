<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ATOM</title>
  <script src="../../scripts/atom/jquery.1.11.2.min.js"></script>
  <script src="../../scripts/atom/jquery-ui.min.js"></script>
  <!-- datetime, date, time -->
  <script src="../../scripts/atom/datetimepicker.moment.js"></script>
  <script src="../../scripts/atom/datetimepicker.js"></script>
  <!-- multiselect -->
  <script src="../../scripts/atom/bootstrap-multiselect.js"></script>
  <!-- amcharts -->
  <script src="../../scripts/atom/amcharts_3.21.2/amcharts/amcharts.js"></script>
  <script src="../../scripts/atom/amcharts_3.21.2/amcharts/serial.js"></script>
  <script src="../../scripts/atom/amcharts_3.21.2/amcharts/pie.js"></script>
  <script src="../../scripts/atom/amcharts_run_atom.js"></script>
  <!-- 공통작성 -->
  <script src="../../scripts/atom/ui_common.js"></script>
  <link rel="shortcut icon" type="image/x-icon" href="../../images/atom/favicon.ico">
  <link rel="stylesheet" href="../../styles/atom/style.css">
  <link rel="stylesheet" href="../../styles/5gprobe/5gprobe.css">
  <script>
  </script>
  <style>
    /* 데모용 style - 개별 페이지 내에 개별 작성 */
    .cont_footer {text-align:center;margin-bottom:10px !important;}
    .cont_footer .btn_area {float:none !important;}
  </style>

  <script>
    $(function() {
      $("#selectRoad").change(function() {
        var categoryVal = $("#selectRoad option:checked").val();
        $.ajax({
          type:"GET",
          url: "/changeRoad?selectRoad=" + categoryVal,
          success: function() {
            location.reload();
           },
           error: function() {
            alert("error");
           }
        });
      });
    });
  </script>
  <script>
    $(function() {
      $("#selectMeasure").change(function() {
        var statusVal = $("#selectMeasure option:checked").val();
        $.ajax({
          type: "GET",
          url: "/changeMeasure?selectMeasure=" + statusVal,
          success: function() {
            location.reload();
          },
          error: function() {
            alert("error");
          }
        });
      });
    });
  </script>

  <script>
    function btnClick() {
      var categoryVal = $("#selectRoad option:checked").val();
      var statusVal = $("#selectMeasure option:checked").val();
      var dataFormat = {RoadCategory : categoryVal, RoadStatus : statusVal};
      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/searchEnvironment",
        success: function(data) {          
          $("#resultDate").append("<div class=" + '"value"'+">" + data.nowDate.substring(0,4) + "년 " + data.nowDate.substring(4,6) + "월 " + data.nowDate.substring(6,8) + "일 " + 
            data.nowDate.substring(8,10) + "시 " + data.nowDate.substring(10,12) + "분" +  "</div>");
        },
        error: function() {
          alert("error");
        }
      });
    }
  </script>

</head>

<body>
  <div class="header"></div>
  <div class="wrap">
    <div class="content">
      <h2 class="h2">서울시 도로변 측정소별 실시간 대기환경 현황</h2>
      <div class="cont_wrap">
        <div class="table type_03 detail">
          <table>
            <tbody>
              <tr>
                <th>
                  <span>도로변 구분 및 측정소</span>
                </th>
                <td>
                  <table class="td_value">
                    <tr>
                      <td>
                        <span class="label">도로변 구분</span>
                        <div class="select type_02 m">
                          <select class="form-control" id="selectRoad" name="selectRoad">
                            <c:forEach items="${categoryList}" var = "item">
                              <option value="${item}" <c:if test ="${Road eq item}"> selected </c:if> >${item}</option>
                              
                            </c:forEach>
                          </select>
                        </div>
                      </td>
                      <td>
                        <span class="label">측정소</span>
                        <div class="select type_02 m">
                          <select id="selectMeasure" name="selectMeasure">
                            <c:forEach items="${nameMap}" var = "item">
                              <c:if test="${item.key eq Road}">
                                <c:forEach items="${item.value}" var = "items">
                                  <option value="${items}" <c:if test="${Measure eq items}"> selected </c:if>>${items}</option>
                              </c:forEach>
                              </c:if>                              
                              
                            </c:forEach>
                          </select>
                        </div>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="cont_footer type_01">
          <div class="btn_area">
            <button type="button" class="btn type_01 primary" id="searchBtn" onclick="btnClick()">조회</button>
          </div>
        </div>
        <div class="table type_03 detail">
          <table>
            <tbody>
              <tr>
                <th>
                  <span>대기 환경 수치</span>
                </th>
                <td>
                  <table class="td_value" >
                    <tr>
                      <td id="resultDate">
                        <span class="label" >수행 일시</span>
                        <!-- <div class="value">2019-10-12 09:03:16</div> -->
                      </td>
                    </tr>
                  </table>
                  <div class="chart_area type_03">
                    <div class="amchart_bar01"></div>
                  </div>
                </td>
              </tr>
              <!-- <tr>
                <th>
                  <span>속성 정보</span>
                </th>
                <td>
                  <div class="table type_04 y_scroll link">
                    <div class="thead">
                      <table>
                        <colgroup>
                          <col>
                          <col>
                          <col>
                          <col>
                        </colgroup>
                        <thead>
                          <tr>
                            <th scope="col">Title</th>
                            <th scope="col" class="tar">최소</th>
                            <th scope="col" class="tar">최대</th>
                            <th scope="col" class="tar">평균</th>
                          </tr>
                        </thead>
                      </table>
                    </div>
                    <div class="tbody">
                      <table>
                        <colgroup>
                          <col>
                          <col>
                          <col>
                          <col>
                        </colgroup>
                        <tbody>
                          <tr>
                            <td>Feature#01</td>
                            <td class="tar">123,456</td>
                            <td class="tar">123,456</td>
                            <td class="tar">123,456</td>
                          </tr>
                          <tr>
                            <td>Feature#01</td>
                            <td class="tar">123,456</td>
                            <td class="tar">123,456</td>
                            <td class="tar">123,456</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </td>
              </tr> --> 
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</body>

</html>