<form method="GET" action="/operaio/addS">
    <div class="row">
        <legend>Segnala una Non Conformità</legend>
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Titolo segnalazione</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" maxlength="50" name="titolo">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Descizione del problema</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" name="desc" type="text" rows= "7" cols="50"></textarea>
    </div>
    <div>
        <button type="submit" class="btn bottone" >Segnala</button>
    </div>
</form>