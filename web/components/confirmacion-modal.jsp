<%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 


<div id="confirmacion-modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form name="frmConfirmacionModal" action="" method="post"
                method="post">
                <div class="modal-header">
                    <h4 id="titulo-confirmacion-modal" class="modal-title"></h4>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                </div>
                <h4 class="ml-3 mt-2" id="mensaje-confirmacion-modal"></h4>
                <input class="d-none" id="idObjetoModal" name="txtIdObjeto" />
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-danger mb-3" data-bs-dismiss="modal" value="No" />
                    <input type="submit" class="btn btn-success mb-3" value="Si" />
                </div>
            </form>
        </div>
    </div>
</div>