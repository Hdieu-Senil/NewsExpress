<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

</div>
    <script src="<%=request.getContextPath()%>/templates/admin/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/plugins.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/main.js"></script>


    <script src="<%=request.getContextPath()%>/templates/admin/js/lib/chart-js/Chart.bundle.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/dashboard.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/widgets.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/lib/vector-map/jquery.vmap.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/lib/vector-map/jquery.vmap.min.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/lib/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="<%=request.getContextPath()%>/templates/admin/js/lib/vector-map/country/jquery.vmap.world.js"></script>
    <script>
        ( function ( $ ) {
            "use strict";

            jQuery( '#vmap' ).vectorMap( {
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: [ '#1de9b6', '#03a9f5' ],
                normalizeFunction: 'polynomial'
            } );
        } )( jQuery );
    </script>

</body>
</html>
