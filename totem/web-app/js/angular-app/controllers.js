angular.module('grailsCron.controllers', []).

  /* Drivers controller */
  controller('croncontroller', function($scope, $routeParams, httpService) {
    $scope.alerts = []
    
  $scope.getInitialData = function() {
    if($routeParams.id != null)
        httpService.get("/totem/cronConsole/getCode/"+ $routeParams.id).then(function(data){
        if(data.code != null){
            code_editor.setValue(data.code)
        }

    })
  }
  $scope.getInitialData()
  $scope.addAlert = function() {
    $scope.alerts.push({msg: 'Another alert!'})
  }

  $scope.closeAlert = function(index) {
    $scope.alerts.splice(index, 1)
  }

  $scope.clearAlerts = function() {
    $scope.alerts = []
  }

  $scope.excuteCode = function() {

    httpService.post("/totem/cronConsole/execute/", {code:code_editor.getValue()}).then(function(data){
        $scope.alerts.push(data)
    })
  }
  $scope.saveCode = function() {

    httpService.post("/totem/cronConsole/update/"+ $routeParams.id, {code:code_editor.getValue()}).then(function(data){
        $scope.alerts.push({"totalTime":null,"output":"Codigo Actualizado Correctamente","result":"OK"})
    })
  }

  })