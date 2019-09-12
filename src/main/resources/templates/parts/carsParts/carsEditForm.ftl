<h3>Edit car</h3>
<#if savingReport??><div>${savingReport}</div></#if>
<div class="form-group mt-3">
    <form method="post" >

        <input type="hidden" name="id" value="<#if car?? && car.id??>${car.id}</#if>">

        <div class="form-group">
            <input type="text" name="mark"
                   class="form-control ${(markError??)?string('is-invalid', '')}"
                   value="<#if car??>${car.mark}</#if>" placeholder="Enter the mark">
            <#if markError??>
                <div class="invalid-feedback">
                    ${markError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="model"
                   class="form-control ${(modelError??)?string('is-invalid', '')}"
                   value="<#if car??>${car.model}</#if>" placeholder="Enter the model">
            <#if modelError??>
                <div class="invalid-feedback">
                    ${modelError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="color"
                   class="form-control ${(colorError??)?string('is-invalid', '')}"
                   value="<#if car??>${car.color}</#if>" placeholder="Enter the color">
            <#if colorError??>
                <div class="invalid-feedback">
                    ${colorError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="vin"
                   class="form-control ${(vinError??)?string('is-invalid', '')}"
                   value="<#if car??>${car.vin}</#if>" placeholder="Enter the number">
            <#if vinError??>
                <div class="invalid-feedback">
                    ${vinError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mt-2">
            <input class="btn btn-primary" type="submit" value="Submit"/>
        </div>
    </form>
</div>