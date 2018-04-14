<h1> Elaborazione numero: ${codice} </h1>
<form  name="" action="">
    <div class="form-group">
        <label> Descrizione </label>
        <textarea class="form-control" name="descrizione"> ${descrizione} </textarea>
    </div>
    <div class="form-group">
        <label> Data Inizio </label>
        <input type="date" class="form-control" readonly="true" value="${DataInizio}" name="dataInizio"/>
    </div>
    <div class="form-group">
        <label> Data Fine </label>
        <input type="date" class="form-control"  placeholder="data fine" name="dataFine"/>
    </div>
    <div class="form-group">
        <label> Non conformita </label>
        <input type="text" class="form-control" readonly="true" value="${nonConformita}" name="nonConformita"/>
    </div>
    <input type="submit" class="form-control"  name="submit">Salva
</form>