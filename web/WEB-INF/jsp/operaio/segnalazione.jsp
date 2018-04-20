<div class="container">
    <form class="well form-horizontal" method="post"  id="addSegnalazione" action="/addS">
        <fieldset>
            <legend>Segnala una Non Conformità</legend>

            <div class="form-group">
                <label class="col-md-4 control-label">Descrizione</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <textarea class="form-control" id="descrizione" name="descSegnalazione" placeholder="Descrizione"></textarea>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-success" >Segnala</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>