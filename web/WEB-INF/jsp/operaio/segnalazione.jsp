<div class="container">
    <form class="well form-horizontal" method="GET" action="/operaio/addS">
        <fieldset>
            <legend>Segnala una Non Conformità</legend>
            
            <div>
                <label>Titolo segnalazione</label><br>
                <input type="text" maxlength="50" name="titolo" />
            </div>

            <div class="mdl-textfield mdl-js-textfield">
                <label>Descizione del problema</label>
                <textarea name="desc" type="text" rows= "7" cols="50" ></textarea>
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
