<html>
<link   href="/css/login.css" rel="stylesheet" type="text/css">
<script src="/js/jquery-1.11.3.js"></script>
<script src="/js/Particleground.js"></script>
<style>
    body {
        height: 100%;
        background: #16a085;
        overflow: hidden;
    }
    canvas {
        z-index: -1;
        position: absolute;
    }
</style>
<script type="text/javascript">
  $(document).ready(function () {
	//粒子背景特效
    $('body').particleground({
        dotColor: '#5cbdaa',
        lineColor: '#5cbdaa'
    });
  });  
</script>
<body>

<canvas class="pg-canvas" width="1134" height="535"></canvas>

</body>
</html>