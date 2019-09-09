<#import "parts/pageTemplate.ftl" as pt>
<#import "parts/login.ftl" as l>

<@pt.page>
    <div class="mb-1">Add new user</div>
    ${message?ifExists}
    <@l.login "/registration" true/>
</@pt.page>