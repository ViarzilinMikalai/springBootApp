<#import "../pager.ftl" as p>

<@p.pager url page/>
<table class="table table-hover table-bordered table-sm">
    <thead class="thead-light">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Mark</th>
            <th scope="col">Model</th>
            <th scope="col">Color</th>
            <th scope="col">VIN</th>
            <th scope="col">Is deleted</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <#list page.content as car>
            <tr ${car.deleted?then("class='alert-danger'", "")}>
                <td scope="row">
                    <#if car.id??>
                        ${car.id}
                    </#if>
                </td>
                <td scope="row">
                    <#if car.mark??>
                        ${car.mark}
                    </#if>
                </td>
                <td scope="row">
                    <#if car.model??>
                        ${car.model}
                    </#if>
                </td>
                <td scope="row">
                    <#if car.color??>
                        ${car.color}
                    </#if>
                </td>
                <td scope="row">
                    <#if car.vin??>
                        ${car.vin}
                    </#if>
                </td>
                <td scope="row">
                    <#if car.deleted??>
                        ${car.deleted?then("true", "false")}
                    </#if>
                </td>

                <td scope="row">
                    <a href="cars?editCar=${car.id}">edit</a>
                </td>
                <td scope="row">
                    ${car.deleted?then('<a href="cars?repareCar=${car.id}">repare</a>',
                    '<a href="cars?removeCar=${car.id}">remove</a>') }
                </td>
            </tr>
        <#else>
            Cars list is Empty
        </#list>
    </tbody>
</table>
<@p.pager url page/>